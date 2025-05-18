import React from 'react'
import HeroSection from '../component/HeroSection'
import NewArrivals from '../component/CarouselSections/NewArrivals'
import TopBrands from '../component/CarouselSections/TopBrands'

const HomePage = () => {
  return (
    <div>
      
      <HeroSection />
      <NewArrivals />
      <TopBrands/>
    </div>
  )
}

export default HomePage
