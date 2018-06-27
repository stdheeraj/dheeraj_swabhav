const ContactService = require('./contact-service');
let contactService = new ContactService();

const contactController = function(app){
    app.group("/api/v1", (router) => {
        router.get("/contacts", getAllContact)
                .get("/:name", getContact)
                .post("/", createContact)
                .put("/:name", updateContact)
                .delete("/:name", deleteContact);
    });
}

function getAllContact(req, res){
    try {
        contactService.displayAllContact().pipe(res);
    } catch (error) {
        res.send(error.message);
    }
}

function getContact(req, res){
    try {
        res.json(contactService.search(req.params.name));
    } catch (error) {
        res.send(error.message);
    } finally{
        res.end();
    }
}

function createContact(req, res){
    try {
        contactService.add(req.body);
        res.send('contact created succefully');
    } catch (error) {
        res.send(error.message);
    } finally{
        res.end();
    }
}

function updateContact(req, res){
    try {
        contactService.update(req.params.name,req.body);
        res.send('contact updated successfully');
    } catch (error) {
        res.send(error.message);
    } finally{
        res.end();
    }
}

function deleteContact(req, res){
    try {
        contactService.remove(req.params.name);
        res.send('contact deleted successfully');
    } catch (error) {
        res.send(error.message);
    } finally{
        res.end();
    }
}

module.exports = contactController;