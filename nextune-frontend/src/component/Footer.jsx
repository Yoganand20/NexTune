import React from 'react'
import Facebook  from '../assets/social/facebook.svg?react';
import Twitter from '../assets/social/twitter.svg?react';
import Instagram from '../assets/social/instagram.svg?react';

const Footer = () => {
  return (
<footer className="footer footer-horizontal footer-center bg-primary text-primary-content p-10">
  <aside>
    <p className="font-bold">
      NexTune
      <br />
      Pleaseing ears since 1992
    </p>
    <p>Copyright © {new Date().getFullYear()} - All right reserved</p>
  </aside>
  <nav>
    <div className="grid grid-flow-col gap-4">
      <a>
        <Facebook className=" h-7 w-7"/>
      </a>
      <a>
        <Twitter className="h-7 w-7"/>
      </a>
      <a>
      <Instagram className="h-7 w-7"/>
        
      </a>
    </div>
  </nav>
</footer>
  )
}

export default Footer
