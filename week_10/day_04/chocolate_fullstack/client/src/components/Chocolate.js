const Chocolate = ({chocolate, deleteChocolate}) => {

    const handleDeleteChocolate = () => {
        deleteChocolate(chocolate.id);
    }

    return(
        <div>
            <h4>{chocolate.name}</h4>
            <p>Estate: {chocolate.estate.name}, {chocolate.estate.country}</p>
            <p>Cocoa percentage: {chocolate.cocoaPercentage}%</p>
            <button onClick={handleDeleteChocolate}>Delete Chocolate</button>
            <hr />
        </div>
    )
}

export default Chocolate;