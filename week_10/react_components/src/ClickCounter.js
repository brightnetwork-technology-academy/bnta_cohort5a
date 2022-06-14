import React from 'react';

class ClickCounter extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            clicks: 0
        }
    }

    clickIncrementer() {
        this.setState((prev) => ({ clicks: prev.clicks + this.props.stepSize }));
    }

    render() {
        return (
            <>
                <h2>Click Counter</h2>
                <label>You've clicked me {this.state.clicks} times</label>
                <button onClick={() => { this.clickIncrementer() }}>Click Me!</button>

            </>
        )
    }
}

export default ClickCounter;