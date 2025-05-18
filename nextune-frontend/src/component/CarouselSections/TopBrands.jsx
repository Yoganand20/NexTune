import React from 'react'
import CarouselHeading from '../common/Carousel/CarouselHeading';
import CarouselCards from '../common/Carousel/CarouselCards';

import Moondroop from '../../assets/BrandLogo/moondrop_logo.svg';
import Shure from '../../assets/BrandLogo/shure-logo.svg';
import Sennheiser from '../../assets/BrandLogo/sennheiser-logo.svg';
import Sony from '../../assets/BrandLogo/sony-logo.svg';
import Bose from '../../assets/BrandLogo/bose-logo.svg';

const TopBrands = () => {
    const topBrandsList = [
        { image: Moondroop, name: 'Moondroop' },
        { image: Shure, name: 'Shure' },
        { image: Sennheiser, name: 'Sennheiser' },
        { image: Sony, name: 'Sony' },
        { image: Bose, name: 'Bose' },
      ];
  return (
    <div className='p-7'>
        <CarouselHeading title={"Top Brands"}/>
        <CarouselCards carouselList={topBrandsList}/>
  </div>
  )
}

export default TopBrands
