/**
 * AWS Module: Action: Modularized Code
 */

var AWS = require('aws-sdk');

// Export For Lambda Handler
module.exports.run = function(event, context, cb) {

  var dynamodb = new AWS.DynamoDB();

  // Récupère toutes les entrées dont la latitude commence par 43
  var params = {
    TableName : "Esafe-Userdatabasw"
  };

  dynamodb.scan(params, function (err, data) {
    if (err) {
      console.error("Unable to query. Error:", JSON.stringify(err, null, 2));

    } else {
      console.log("Query succeeded.");
      data.Items.forEach(function(item) {
        console.log(" -", item.year + ": " + item.title);
      });
    }

    cb(null, {"data": data, "err": err});
  });

};
