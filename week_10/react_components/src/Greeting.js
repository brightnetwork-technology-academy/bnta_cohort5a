import React from 'react';

// historically, class components were 'stateful' and functional components were 'stateless'. With the introduction of hooks such as 
// useState() to functional components, the distinction is now moot. Functional components a preferable in all cases. However, you
// mak encounter legacy code in your places of work which utilise old-fashioned class components

// classes have lifecycle methods instead of hooks like useState

class Greeting extends React.Component {
    // constructor(props) {
    //     super(props);
    // }

    render(){
        return <div>Greeting to world {this.props.name}</div>
    }

    componentDidUpdate(){
        super.componentDidUpdate();
    }
}

export default Greeting;