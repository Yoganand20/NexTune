import React from 'react'
import ProductCard from '../common/ProductCard'
const ProductGrid = ({products}) => {
    return (
        <div>
            <div className="w-full grid grid-cols-1 sm:grid-cols-1 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-4 p-4 grid-flow-row auto-rows-fr">
                {products.map((product, index) => (
                    <div key={index} className="aspect-square min-w-0">
                        <ProductCard
                            {...product}
                            className="w-full h-full"
                        />
                    </div>
                ))}
            </div>
        </div>
    )
}

export default ProductGrid
