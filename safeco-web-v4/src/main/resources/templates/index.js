/**
 * 
 */
function handleSubmit () {
    const zipcode = document.getElementById('zipcode').value;

    // to set into local storage
    /* localStorage.setItem("NAME", name);
    localStorage.setItem("SURNAME", surname); */
    
    sessionStorage.setItem("ZIPCODE", zipcode);

    return;
}
