const dataService = function(){
    let obj = {};

    let name = ['dheeraj', 'santosh', 'vipul'];

    obj.getData = function(cb){
        process.nextTick(()=>cb(name));
    }

    obj.getDataSync = function(){
        return name;
    }

    return obj;
}

module.exports = dataService;