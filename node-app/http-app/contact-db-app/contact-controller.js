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
        contactService.displayAllContact((result)=>{
            if(result.length == 0)
                res.send('No contact is found.')
            else
                res.json(result);
            res.end();
        });
    } catch (error) {
        //console.log(error);
        res.send(error);
        res.end();
    }
}

function getContact(req, res){
    try {
        contactService.search(req.params.name, (result)=>{
            if(result.length == 0)
                res.send('No contact is found.')
            else
                res.json(result);
            res.end();
        });
    } catch (error) {
        res.send(error.message);
        res.end();
    }
}

function createContact(req, res){
    try {
        //contactService.add(req.body);
        contactService.add(req.body, (result)=>{
            //console.log(result)
            if(result.affectedRows == 0)
                res.send(req.body.name+" is not created.");
            else
                res.send('Contact created successfully');
            
            res.end();
        });
    } catch (error) {
        res.send(error.message);
        res.end();
    }
}

function updateContact(req, res){
    try {
        contactService.update(req.params.name,req.body,(result)=>{
            //console.log(result)
            if(result.affectedRows == 0)
                res.send(req.params.name+" is not updated.");
            else
                res.send('Contact updated successfully');
            
            res.end();
        });
    } catch (error) {
        res.send(error.message);
        res.end();
    }
}

function deleteContact(req, res){
    try {

        contactService.remove(req.params.name, (result)=>{
            if(result.affectedRows == 0)
                res.send(req.params.name+" is Not Found.");
            else
                res.send('Contact deleted successfully');
            
            res.end();
        });

    } catch (error) {
        res.send(error.message);
        res.end();
    }
}

module.exports = contactController;