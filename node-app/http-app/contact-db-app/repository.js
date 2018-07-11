const mysql      = require('mysql');

class Connection{

    demo(){
        return this.fireQuery('SELECT * FROM contacts');
    }

    fireQuery(query){
        //console.log("inside query");

        const connection = mysql.createConnection({
            host     : 'localhost',
            user     : 'root',
            password : 'root',
            database : 'contact-db'
          });
        
        return new Promise((resolve, reject) => {
            connection.connect((error)=>{
                if(error)
                    reject(error);
                else{
                    connection.query(query, (error, results) => {
                        //console.log('inside q '+results);
                        if (error) 
                            reject(error);
                        else
                            resolve(results);
        
                        connection.end();
                    });
                }
            });
        });
    }
}

module.exports = Connection;