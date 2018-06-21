let balance = 500;

let deposit = function(amt, callback){
    balance +=amt;
    callback(balance);
}

deposit(500, (newBalance) => console.log('Balance changed to '+ newBalance));

setTimeout(()=> console.log('email notification  send after 2 seconds'), 2000);

var name = ['dheeraj', 'santosh', 'vipul'];
name.map(n => console.log(n));

var capitalNames = name.map(n => n.toUpperCase());

console.log(capitalNames);

capitalNames.map(n=> console.log(n));