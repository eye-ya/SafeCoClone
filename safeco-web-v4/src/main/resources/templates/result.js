/**
 * 
 */
window.addEventListener('load', () => {

    const zipcode = sessionStorage.getItem('ZIPCODE');
    
    document.getElementById('result-zipcode').innerHTML = zipcode;

})