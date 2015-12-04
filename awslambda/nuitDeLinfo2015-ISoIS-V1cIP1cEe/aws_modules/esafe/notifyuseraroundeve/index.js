/**
 * AWS Module: Action: Modularized Code
 */

var AWS = require('aws-sdk');

var toRadians = function(v) {
  return v * Math.PI / 180;
}

var getBoundingBox = function(latitude, longitude, distance) {

  var latRadian = toRadians(latitude);

  var degLatKm = 110.574235;
  var degLongKm = 110.574235 * Math.cos(latRadian);
  var deltaLat = distance / 1000.0 / degLatKm;
  var deltaLong = distance / 1000.0 / degLongKm;

  var minLat = latitude - deltaLat;
  var minLong = longitude - deltaLong;
  var maxLat = latitude + deltaLat;
  var maxLong = longitude + deltaLong;

  return {
    min: {
      lat: minLat,
      long: minLong
    },
    max : {
      lat: maxLat,
      long: maxLong
    }
  }

}




// Export For Lambda Handler
module.exports.run = function(event, context, cb) {

  var sourceUser = event.sourceUser;
  var latitude = event.latitude;
  var longitude = event.longitude;

  var dynamodb = new AWS.DynamoDB();

  // Calcul des bornes des coordonnées pour un rayon de 10km
  var boundingBox = getBoundingBox(latitude, longitude, 10)

  var requestparams = {
    TableName: "Esafe-Userdatabasw",
    KeyConditionExpression: "latitude between :latmin and :latmax and longitude between :longmin and :longmax",
    ExpressionAttributeValues: {
      ":latmin": boundingBox.min.lat,
      ":latmax": boundingBox.max.lat,
      ":longmin": boundingBox.min.long,
      ":longmax": boundingBox.max.long
    }
  }

  dynamodb.query(requestparams, function (err, data) {
    if (err) {
      console.error("Unable to query. Error:", JSON.stringify(err, null, 2));

    } else {
      console.log("Query succeeded.");
      data.Items.forEach(function(item) {
        console.log(" -", item.year + ": " + item.title);
      });
    }


    // TODO: Envoyer un email au users

    cb(null, {"data": data, "err": err});
  });
};

// Your Code
var action = function(event, context) {



  //return {message: 'Event received from ' + sourceUser + ' for latitude: ' + latitude + ' longitude:' + longitude};

  return {"eventData": JSON.stringify(event)}
};
