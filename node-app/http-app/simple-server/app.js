const http = require('http');
const fs = require('fs');

http.createServer(function (req, res) {
    let resourceName = 'index.html';

    if (req.url == '/api')
        resourceName = 'data.json';
    else if (req.url != '/')
        resourceName = req.url.substring(1);

    let resourcePath = 'public/' + resourceName;
    
    let seperateName = resourceName.split(".");

    let type = 'text/html';

    if (seperateName[1] == 'json')
        type = 'application/json';
    
    if (seperateName[1] == 'gif')
        type = 'image/gif';

    try {
        if (fs.existsSync(resourcePath)) {
            res.writeHead(200, { "Content-type": type });
            
            /*fs.readFile(resourcePath,(e,r)=>{
                if(e)
                    throw new Error(e.message)
                res.write(r);
                res.end();
            })*/

            let stream = fs.createReadStream(resourcePath);
            stream.pipe(res);
            
        } else {
            res.writeHead(404, { "Content-Type": type });
            res.write('404! Resource Not Found!');
            res.end();
        }
    } catch (err) {
        res.write('<br>Error: ' + err.message);
    }
}).listen(8080, () => console.log('App listening on port 8080'));