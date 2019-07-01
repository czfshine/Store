
function getStoreID(obj){
    let url = "/api/store/firstid";
    let id;

    fetch(url)
            .then(response => {
                let body=response.text().then(value => {
                    obj.storeid= parseInt(value);
                });
            });
}
export default getStoreID;