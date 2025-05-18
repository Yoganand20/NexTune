import React from 'react'
import heroSectionBanner from '../assets/heroSection-headphones.jpg'



function HeroSection() {
    return (
        <div
            className="hero min-h-screen"
            style={{
                backgroundImage:`url(${heroSectionBanner})`,
            }}
        >
            <div className="hero-overlay"></div>
            <div className="hero-content text-neutral-content text-center">
                <div className="max-w-md">
                    <h1 className="mb-5 text-5xl font-bold">Experience Music As It Was Meant to Be Heard</h1>
                    <p className="mb-5">
                    From professional IEMs to wireless headphones, find your perfect audio companion
                    </p>
                    <button className="btn btn-primary">Explore Collection</button>
                </div>
            </div>
        </div>
    )
}

export default HeroSection