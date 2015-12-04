/**
 * AWS Module: Action: Modularized Code
 */

// Export For Lambda Handler
module.exports.run = function(event, context, cb) {
  return cb(null, action(event, context));
};

// Your Code
var action = function(event, context) {

//  var sourceUser = event.sourceUser;
  //var latitude = event.latitude;
  //var longitude = event.longitude;

  //return {message: 'Event received from ' + sourceUser + ' for latitude: ' + latitude + ' longitude:' + longitude};

  return {"message": JSON.stringify(event)}
};
