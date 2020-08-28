const express = require('express')
const app = express()
var db =  require('./db');
var port = 3001;

var Openpay = require('openpay');
const { response } = require('express');


app.get('/articulos', (req, res) => {
  db.query('SELECT * from articulos', function (error, results, fields) {
    if (error) throw error;
    res.json(results);
  });
});

app.get('/', (req, res) => {

    //console.log(openpay);
    res.send('Hello World!')
});

app.get('/verificarPago', (req, res) =>{
    var openpay = new Openpay('ml2k9ihovethfcnynbec', 'sk_5567173019af4c97a6992809c3bc400b', false);

  /*  var newCustomer = {
        "name":"John",
        "email":"johndoe@example.com",
        "last_name":"Doe",
        "address":{
          "city":"Queretaro",
          "state":"Queretaro",
          "line1":"Calle Morelos no 10",
          "line2":"col. san pablo",
          "postal_code":"76000",
          "country_code":"MX"
        },
        "phone_number":"44209087654"
      };
      
      openpay.customers.create(newCustomer, function(error, body) {
          error;    // null if no error occurred (status code != 200||201||204)
          res.send(body);    // contains the object returned if no error occurred (status code == 200||201||204)
      });*/

   var newCharge = {
       'source_id':'khctjqlbymbdema32wz6',
        "method": "card",
        "amount" : 200.00,
        'currency' : 'MXN',
        "description" : "Service Charge",
        "order_id" : "oid-00721",
        'device_session_id' : 'bbb49bcee869A1eaadc10242ac120002',
        'customer' : {
          'name' : 'Felipe',
          'last_name' : 'Hernandez Palafox',
          'phone_number' : '4771874409430',
          'email' : 'felipe.sistemas.fhp@gmail.com'
        }
       
      };
      openpay.charges.create(newCharge, function (error, body){         
        res.send(body);
      });


});

app.listen(port, () => console.log(`Example app listening at http://localhost:${port}`))