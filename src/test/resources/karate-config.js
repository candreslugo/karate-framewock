function fn(){
    var env=karate.env;
    console.log('karate.env system properti was:',env);
    if (!env){
        env = 'dev';
    }
    var config={
        appid:'my.app.id',
        appSecret: 'my.secret',
        someUrlBase: 'https://some-host.com/v1/auth',
        anotherUrlBase: 'https://another-host.com/v1'
    };
    if (env=='stage'){
        config.anotherUrlBase = 'https://some-host.com/v1/auth';

    }else if (env=='e2e'){
        config.someUrlBase = 'http://e2e-host/v1/auth';
    }
    karate.configure('connectTimeout',5000);
    karate.configure('readTimeOut',5000);
    return config;
}
