var nodemailer = require('nodemailer');

var transporter = nodemailer.createTransport({
  service: 'gmail',
  auth: {
    user: 'cdheeraj76@gmail.com',
    pass: 'password'
  },
  tls: {
      rejectUnauthorized: false
  }
});

var mailOptions = {
  from: 'cdheeraj76@gmail.com',
  to: 'kannan@swabhavtechlabs.com',
  subject: 'Sending Email using Node.js',
  text: 'Good Morning sir, This mail is send throught node js application.'
};

transporter.sendMail(mailOptions, function(error, info){
  if (error) {
    console.log(error);
  } else {
    console.log('Email sent: ' + info.response);
  }
  transporter.close();
});