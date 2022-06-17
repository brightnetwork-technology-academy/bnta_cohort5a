import NewChocolateForm from '../components/NewChocolateForm';
import ChocolateList from '../components/ChocolateList';
import {useEffect, useState} from 'react';

const ChocolateContainer = () => {

    const [chocolates, setChocolates] = useState([])

    useEffect(() => {
        fetch("http://localhost:8080/chocolates")
            .then(response => response.json())
            .then(data => setChocolates(data))
    }, [])

    const [estates, setEstates] = useState([])

    useEffect(() => {
        fetch("http://localhost:8080/estates")
            .then(response => response.json())
            .then(data => setEstates(data))
    }, [])

    const postChocolate = (newChocolate) => {
        // add the new chocolate to db/server
        fetch("http://localhost:8080/chocolates", 
        {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(newChocolate)
        })
        // update locally
        .then(response => response.json())
        .then(savedChocolate => setChocolates([...chocolates, savedChocolate]))
    }

    const deleteChocolate = (id) => {
        // deal with db
        fetch("http://localhost:8080/chocolates/" + id, {
            method: "DELETE",
            headers: {"Content-Type": "application/json"}
        })
        // delete locally
        setChocolates(chocolates.filter(chocolate => chocolate.id != id))
    }

    return (
        <>
            <h1>Single Origin Chocolate</h1>
            <p>a resource for chocoholics</p>
            <NewChocolateForm 
                    estates={estates}
                    postChocolate={postChocolate}/>
            <ChocolateList 
                    chocolates={chocolates}
                    deleteChocolate={deleteChocolate}/>
        </>
    )
}

export default ChocolateContainer;