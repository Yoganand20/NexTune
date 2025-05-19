import React from 'react';
import { ShoppingCartIcon } from 'lucide-react';
const CarouselCards = ({ carouselList }) => {

  const carouselItems = carouselList.map((item, index) => {
    return (
      <div className="card bg-base-100 w-96 shadow-sm min-w-80" key={index}>
        <figure className='relative aspect-square'>
          <div className="absolute inset-0 z-10 bg-white text-center flex flex-col items-center justify-center opacity-0 hover:opacity-90 bg-opacity-100 duration-300 gap-2.5">
            <a href="#" className="text-white bg-blue-700 hover:bg-blue-800 opacity-100 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800" >
              View
            </a>
          </div>
          <img
            className='w-full h-full object-cover'
            src={item.image}
            alt={item.name} />
        </figure>
        <div className="card-body">
          <h2 className="card-title">
            {item.name}
            {/* <div className="badge badge-secondary">NEW</div> */}
          </h2>
          {
            item.desc &&(
              <p>{item.desc}</p>
            )
            
          }
          {
            item.price && (
              <div className="flex items-center justify-between">
                <span className="text-3xl font-bold text-neutral">₹ {item.price}</span>
                <a href="#" className="flex flex-row text-white bg-blue-700 hover:bg-blue-800 opacity-100 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                  <ShoppingCartIcon />
                </a>
              </div>
            )
          }
        </div>
      </div>
    );
  });

  return (
    <div className="carousel carousel-start rounded-box w-full space-x-4 p-4">
      {carouselItems}
    </div>
  );
};

export default CarouselCards;
