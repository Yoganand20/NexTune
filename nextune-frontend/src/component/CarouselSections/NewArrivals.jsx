import React from 'react'
import CarouselCards from '../common/Carousel/CarouselCards'
import CarouselHeading from '../common/Carousel/CarouselHeading'

import TruthearZeroBlue2 from '../../assets/NewArrivals/Headphone-Zone-Truthear-x-Crinacle-ZERO-BLUE2-Without-mic-02.webp'
import TangzeWanerSG2 from '../../assets/NewArrivals/Headphone-Zone-Tangze-Waner-SG-2-Black-4.4mm-Without-Mic-103.webp'
import FiiOBRT11 from '../../assets/NewArrivals/Headphone-Zone-FiiO-BRT11-black-009.webp'
import CampfireAudioAxion from '../../assets/NewArrivals/Headphone-zone-Campfire-Audio-Axion-02.webp'
import ActivoP1 from '../../assets/NewArrivals/Headphone-Zone-ACTIVO-P1-01.webp'

const NewArrivals = () => {
  const newArrivalsList = [
    { image: TruthearZeroBlue2, name: 'Truthear X Crinacle: Zero Blue 2', price: '5,999' },
    { image: TangzeWanerSG2, name: 'Tangze Waner S. G. 2', price: '1,890' },
    { image: FiiOBRT11, name: 'FiiO BRT11', price: '1,999' },
    { image: CampfireAudioAxion, name: 'Campfire Audio Axion', price: '23,999' },
    { image: ActivoP1, name: 'Activo P1', price: '39,999' },

  ];
  return (
    <div className='p-7'>
      <CarouselHeading title={"New Arrivals"} />
      <CarouselCards carouselList={newArrivalsList} />
    </div>
  )
}

export default NewArrivals
