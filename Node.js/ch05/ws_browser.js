<script type= "text/javascript">
var ws= new Websocket(ws://127.0.0.1: 8080)
ws. onopen=function(
console. log(websocket open),
document. getelementbyld("stat) innerhtml="已连接上
ws onclose=function
console. log(websocket close
document. getelementbyld("stat"). innerhtml=”连接断开”
wsonmessage= function(event)(
console. log(event data)
document.getelementbyld(recvtxt)value=eventdata,
document.getelementbyld('sendbtn)onclick=function(
var txt=document. getelementbyld(send").value
ws. send(txt)
</script>