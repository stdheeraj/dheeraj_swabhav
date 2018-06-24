const fs = require('fs');

let repoData = fs.readFileSync('github-repository.json');  
const users = JSON.parse(repoData);

class GithubService {
    getUser(id){
        return new Promise((resolve,reject) => {
            //console.log(users.map((d)=>d.repository));

            users.forEach((user) => {
                if(user.id == id)
                    resolve(user);
                else
                    reject(new Error("\nNot Authenticated User"));
            });
        });
    }

    getRepository(user){
        return new Promise((resolve,reject) => {
                if(user.hasOwnProperty('repository'))
                    resolve(user.repository);
                else
                    reject(new Error("\nRepository Not Available."));
        });
    }

    getCommits(repos){
        return new Promise((resolve,reject) => {
                if(repos)
                    resolve(repos.commits);
                else
                    reject(new Error("\nCommits Not Available."));
        });
    }
}

module.exports = GithubService;