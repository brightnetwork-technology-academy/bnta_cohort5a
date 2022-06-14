
const makeRequest = (location, request)=> {
    return new Promise((resolve, reject)=>{
        if(location == 'www.google.com'){
            resolve('Goolge says hi');
        }
        else {
            reject('sorry, we only handle Google requests');
        }
    })
};

const handleRequest = (response)=> {
    return new Promise((resolve, reject)=> {
        resolve("Additional info: " + response);
    })
};

makeRequest('www.google.com', 'hi').then(response => {
    console.log('making request');
    return handleRequest(response);
}).then(processedResponse => {
    console.log(processedResponse);
}).catch(err => {
    console.error(err);
});

const request = async ()=>{
    try {
        const response = await makeRequest('www.google.com', 'yo');
        const processedResponse = await handleRequest(response);
        console.log("from async: " + processedResponse);
        // await (()=> {
        //     console.log(processedResponse);
        // })();
    } catch (err) {
        console.error(err);
    }
}

request();
console.log('should execute afterwards')