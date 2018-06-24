const GithubService = require('./github-service');

let gitsrv = new GithubService();

gitsrv.getUser(1001)
.then((d)=>gitsrv.getRepository(d))
.then((repos)=>gitsrv.getCommits(repos[0]))
.then((commits)=>commits.map((c)=>console.log(c)))
.catch((e) => console.log(e.message) )