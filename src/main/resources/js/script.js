let socket = new WebSocket("wss://localhost:8080/demo");

socket.onopen = function(e){
    alert('[open] Connection Established');

};

socket.onmessage = function(event){
    alert('[message] Data received from server: ${event.data}');
    document.getElementById("reeceived").value += '${event.data}';
};

socket.onclose = function(event){
    alert('[close] Connection Closed');
};

socket.onerror = function(error){
    alert('[error]');
};

function handle_error(error) {
	alert(error.toString());
}

function post(url, data) {
	return fetch(url, { method: 'post', body: data });
}