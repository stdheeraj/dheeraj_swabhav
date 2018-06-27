const filters = function(app){
    app.use(logFilter);
    app.use(cookieFilter);
    app.use(compressionFilter);
}

function logFilter(req, res, next){
    console.log('Log in going on...');
    next();
    console.log('Login completed');
}

function cookieFilter(req, res,next){
    console.log('Setting cookie...'+req.query.name);
    next();
    console.log('Cookie is set.');
}

function compressionFilter(req, res){
    console.log('Data is compressed.');
}

module.exports = filters;