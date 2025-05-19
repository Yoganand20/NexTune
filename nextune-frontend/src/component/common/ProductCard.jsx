import React from 'react'
import { ShoppingCartIcon } from 'lucide-react';
const ProductCard = ({imageURL,name,desc,price}) => {
    
  return (
    <div>
      <div className="card bg-base-100 h-fit w-72 shadow-sm min-w-72">
        <figure className='relative aspect-square'>
          <div className="absolute inset-0 z-10 bg-white text-center flex flex-col items-center justify-center opacity-0 hover:opacity-90 bg-opacity-100 duration-300 gap-2.5">
            <a href="#" className="text-white bg-blue-700 hover:bg-blue-800 opacity-100 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800" >
              View
            </a>
          </div>
          <img
            className='object-cover'
            src={imageURL}
            alt={name} />
        </figure>
        <div className="card-body">
          <h2 className="card-title">
            {name}
            <div className="badge badge-secondary">NEW</div>
          </h2>
          {
            desc &&(
              <p>{desc}</p>
            )
            
          }
          {
            price && (
              <div className="flex items-center justify-between">
                <span className="text-3xl font-bold text-neutral">₹ {price}</span>
                <a href="#" className="flex flex-row text-white bg-blue-700 hover:bg-blue-800 opacity-100 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                  <ShoppingCartIcon />
                </a>
              </div>
            )
          }
        </div>
      </div>
    </div>
  )
}

export default ProductCard;
