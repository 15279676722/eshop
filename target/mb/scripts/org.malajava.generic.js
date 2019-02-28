( function(w){

    var refresh = function( image ){
        var url = image.src ;
        var index = url.indexOf( "?" ) ;
        index =  index == -1 ? url.length : index ;
        url = url.substring( 0 , index );
        url = url + "?t=" + Date.now();
        image.src = url ;
    }

    if( w.X ){
        w.X.refresh = refresh ;
    } else {
        w.X = { "refresh" : refresh  }
    }
})(window);