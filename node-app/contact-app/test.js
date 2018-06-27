var readlineSync = require('readline-sync');


email = readlineSync.questionEMail();
console.log('-- E-mail is ' + email);

//numInt = readlineSync.questionInt([query[, options]])

//boolYes = readlineSync.keyInYNStrict([query[, options]])

frameworks = ['Express', 'hapi', 'flatiron', 'MEAN.JS', 'locomotive'];
index = readlineSync.keyInSelect(frameworks, 'Which framework?');
console.log(frameworks[index] + ' is enabled.');

// Have made the preparations for something...
console.log('==== Information of Your Computer ====');
console.log(info); // This can be `query`.
readlineSync.keyInPause();
console.log('It\'s executing now...');
// Do something...

menuId = readlineSync.keyIn('Hit 1...5 key: ', {limit: '$<1-5>'});


/*
readlineSync.promptCLLoop({
    add: function(target, into) {
      console.log(target + ' is added into ' + into + '.');
      // Do something...
    },
    remove: function(target) {
      console.log(target + ' is removed.');
      // Do something...
    },
    bye: function() { return true; }
  });
  console.log('Exited');
*/



/*
if (readlineSync.keyInYN('Do you want this module?')) {
  // 'Y' key was pressed.
  console.log('Installing now...');
  // Do something...
} else {
  // Another key was pressed.
  console.log('Searching another...');
  // Do something...
}
*/

/*
animals = [()=>console.log('hello'), 'Elephant', 'Crocodile', 'Giraffe', 'Hippo'],
  index = readlineSync.keyInSelect(animals, 'Which animal?');
  animals[index]();
//console.log('Ok, ' + animals[index] + ' goes to your room.');
*/
 
/*
let MAX = 60, MIN = 0, value = 30, key;
console.log('\n\n' + (new Array(20)).join(' ') +
  '[Z] <- -> [X]  FIX: [SPACE]\n');
while (true) {
  console.log('\x1B[1A\x1B[K|' +
    (new Array(value + 1)).join('-') + 'O' +
    (new Array(MAX - value + 1)).join('-') + '| ' + value);
  key = readlineSync.keyIn('',
    {hideEchoBack: true, mask: '', limit: 'zx '});
  if (key === 'z') { if (value > MIN) { value--; } }
  else if (key === 'x') { if (value < MAX) { value++; } }
  else { break; }
}
console.log('\nA value the user requested: ' + value);
*/