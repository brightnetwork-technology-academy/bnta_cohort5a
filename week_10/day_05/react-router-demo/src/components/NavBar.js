import { Link } from 'react-router-dom';

function NavBar() {
    return (
        <ul>
            {/* Use the Link component to define menu items */}
            <li><Link to='/'>Home</Link></li>
            <li><Link to='/about'>About</Link></li>
            <li><Link to='/services'>Services</Link></li>
            <li><Link to='/contact'>Contact</Link></li>
        </ul>
    )
}

export default NavBar;