const express = require('express')
const app = express()
var db =  require('./db');
var port = 3001;

const { response } = require('express');


app.get('/articulos', (req, res) => {
  db.query('SELECT * from articulos', function (error, results, fields) {
    if (error) throw error;
    res.json(results);
  });
});

app.get('/', (req, res) => {
    res.send('Hello World!')
});

app.listen(port, () => console.log(`Example app listening at http://localhost:${port}`))