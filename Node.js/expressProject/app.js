const express = require('express');
const bookquery = require('./bookquery.js');
const app = express();
app.use(express.json());
app.use(express.urlencoded());

app.get('/',function(req,res){
    res.redirect('/books');
});

app.get('/books',(req,res) => {
    var bookid = parseInt(req.params.id);
    bookquery.get(bookid,function(rec){
        res.json(rec).end();
    })
})

app.post('/books',function(req,res){
    var reqbody = req.body;
    var arr = [];
    
    for(var key in reqbody){
        arr.push(reqbody[key]);
    }

    bookquery.add(arr,function(rec){
        res.json(rec).end();
    })
})

app.put('/books/:id',function(req,res){
    var bookid = parseInt(req.params.id);
    var reqbody = req.body;

    bookquery.get(bookid,function(rec){
        if(rec.length == 0){
            res.status(404).json({msg: '指定ID的图书不存在！'});
        }else{
            var arr1 = [];
            var arr2 = [];
            for(var key in reqbody){
                arr1.push(key);
                arr2.push(reqbody[key]);
            }

            bookquery.update(bookid,arr1,arr2,function(rec){
                res.json(rec).end();
            })
        }
    })
})


app.daelete('/books/:id',function(req,res){
    var bookid = parseInt(req.params.id);
    var reqbody = req.body;

    bookquery.get(bookid,function(rec){
        if(rec.length == 0){
            res.status(404).json({msg: '指定ID的图书不存在！'})
        }else{
            bookquery.del(bookid,function(p){
                res.json(rec).end();
            })
        }
    })
})


const port = process.env.port || 5000;
app.listen(port,function(){console.log('监听接口： ${porst}')});