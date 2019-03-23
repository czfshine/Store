
import client from './client.js'
function getModelLink(modelname){
    var name="";
    client({method: 'GET', path: '/data/'}).done(response => {
        console.log(response);
        console.log(response.entity._links[modelname]);
        name=response.entity._embedded.products;
        
    });
    return name;
}

export default getModelLink;