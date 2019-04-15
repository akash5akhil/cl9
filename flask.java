from flask import Flask
from flask import jsonify,json
import pandas as pd
#json_string = json.dumps(datastore)




app = Flask(__name__)

@app.route('/home.html')
def index():
	return "HELLO WORLD"

@app.route('/users')
def disp_users():
	data = pd.read_json('users.json')
	data = data.values.tolist()
	return jsonify(data)

@app.route('/movies')
def disp_movies():
	data_movies = pd.read_json('users.json')
	data_movies = data_movies.values.tolist()
	return jsonify(data_movies)

@app.route('/booking')
def disp_booking():
	data_booking = pd.read_json('users.json')
	data_booking = data_booking.values.tolist()
	return jsonify(data_booking)

@app.route('/showtimes')
def disp_showtimes():
	data_showtimes = pd.read_json('users.json')
	data_showtimes = data_showtimes.values.tolist()
	return jsonify(data_showtimes)


if __name__=='__main__':
	app.run(debug = True)

$$.html$$
<html>

<a href="http://127.0.0.1:5000/users">Click here to view user data</a><br>
<a href="http://127.0.0.1:5000/booking">Click here to view bookings</a><br>
<a href="http://127.0.0.1:5000/showtimes">Click here to view showtimes</a><br>
<a href="http://127.0.0.1:5000/movies">Click here to view movies</a><br>

</html>