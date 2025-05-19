import React from 'react'

const CarouselHeading = ({ title }) => {
    return (
        <div className='flex flex-wrap px-10 my-5 items-center gap-2'>
            <div className="rounded bg-primary w-2 h-10"></div>
            <p className='text-2xl text-primary'>{title}</p>
        </div>
    )
}

export default CarouselHeading
