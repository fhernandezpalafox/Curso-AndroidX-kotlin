const express = require('express')
const app = express()
var db =  require('./db');
const bodyParser = require('body-parser');
var port = 3001;

app.use(bodyParser.urlencoded({extended: false}));
app.use(bodyParser.json());

//select 
app.get('/articulos', (req, res) => {
  db.query('SELECT * from articulos', function (error, results, fields) {
    if (error) throw error;
    res.json(results);
  });
});


//Insert 
app.post('/articulos', (req, res) => {
  console.log(req.body.nombre);
  db.query('insert into articulos (nombre,descripcion,cantidad) VALUES(?,?,?)',[req.body.nombre,
                                                                      req.body.descripcion,
                                                                      req.body.cantidad],function (error, results) {
      if (error){
         res.json({
           error:"Surgio un error"+error,
           numero:501
         });
      }else{
        res.json({
          id: results.insertId,
          nombre:req.body.nombre,
          descripcion:req.body.descripcion,
          cantidad: req.body.cantidad
        });
      }

      
  });
});

//update
app.put('/articulos', (req, res) => {
  db.query('update articulos set nombre = ? ,descripcion = ?,cantidad = ? where id = ?;',[req.body.nombre,
                                                                                          req.body.descripcion,
                                                                                          req.body.cantidad,req.body.id], function (error, results) {
    if (error) throw error;
    res.json(results);
  });
});

//delete
app.delete('/articulos', (req, res) => {
  db.query('delete from articulos where id = ?',[req.body.id], function (error, results, fields) {
    if (error) throw error;
    res.json(results);
  });
});


app.get('/', (req, res) => {
    res.send('Hello World!')
});


app.listen(port, () => console.log(`Example app listening at http://localhost:${port}`))