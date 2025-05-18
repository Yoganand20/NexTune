import React from 'react'
import { Heart, ShoppingCart, User, Search} from 'lucide-react'


function Navigation() {
    return (
        <div className="navbar bg-base-100 shadow-sm sticky top-0 z-50">
            <div className="navbar-start">
                {/* on smaller screens */}
                <div className="dropdown">
                    {/* hamburger menu icon */}
                    <div tabIndex="0" role="button" className="btn btn-ghost lg:hidden">
                        <svg xmlns="http://www.w3.org/2000/svg" className="h-5 w-5" fill="none" viewBox="0 0 24 24" stroke="currentColor"> <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M4 6h16M4 12h8m-8 6h16" /> </svg>
                    </div>
                    {/* dropdown menu */}
                    <ul
                        tabIndex="0"
                        className="menu menu-sm dropdown-content bg-base-100 rounded-box z-1 mt-3 w-52 p-2 shadow">
                        <li><a>Offers</a></li>
                        <li>
                            <a>Categories</a>
                            <ul className="p-2">
                                <li><a>IEM</a></li>
                                <li><a>Headphons</a></li>
                                <li><a>DACs and Amps</a></li>
                                <li><a>Accessories</a></li>
                            </ul>
                        </li>
                        <li><a>About</a></li>
                        <li><a>Help Center</a></li>
                    </ul>
                </div>
                {/* Logo */}
                <a className="btn btn-ghost text-xl">NexTune</a>
            </div>
            {/* on larger screens */}
            <div className="navbar-center hidden lg:flex">
                <ul className="flex menu menu-horizontal px-1">
                    <li><a>Offers</a></li>

                    <li>
                        <details>
                            <summary>Categories</summary>
                            <ul className="p-2">
                                <li><a>IEM</a></li>
                                <li><a>Headphons</a></li>
                                <li><a>DACs and Amps</a></li>
                                <li><a>Accessories</a></li>
                            </ul>
                        </details>
                    </li>

                    <li><a>About</a></li>
                    <li><a>Help Center</a></li>
                </ul>
            </div>

            <div className="navbar-end flex gap-2">
                {/* search bar */}
                <Search size={18}/>

                <input type="text" placeholder="Search" className=" input-bordered w-24 md:w-auto outline-none" >
                </input>
                <ul className="flex px-1 gap-2">
                    <li><a role="button" className="btn btn-ghost btn-circle avatar"><Heart size={18}/></a></li>
                    <li><a role="button" className="btn btn-ghost btn-circle avatar"><ShoppingCart size={18}/></a></li>
                </ul>
                {/* dropdown menu */}
                <div className="dropdown dropdown-end">

                    <div tabIndex={0} role="button" className="btn btn-ghost btn-circle avatar">
                        <User size={18}/>
                        {/* <div className="w-10 rounded-full">
                            <img
                                alt="Tailwind CSS Navbar component"
                                src="https://img.daisyui.com/images/stock/photo-1534528741775-53994a69daeb.webp" />
                        </div> */}
                    </div>
                    <ul
                        tabIndex={0}
                        className="menu menu-sm dropdown-content bg-base-100 rounded-box z-1 mt-3 w-52 p-2 shadow">
                        <li>
                            <a className="justify-between">
                                Profile
                                <span className="badge">New</span>
                            </a>
                        </li>
                        <li><a>Settings</a></li>
                        <li><a>Logout</a></li>
                    </ul>
                </div>
            </div>
        </div>
    )
}

export default Navigation