import { createBrowserRouter } from "react-router";
import HomePage from "./pages/HomePage";
import About from "./pages/About";
import App from "./App";
import CategoryListing from "./component/ProductListing/CategoryListing";
let router = createBrowserRouter([
    {
        path: "/",
        Component: App,
        children: [
            { index: true, Component: HomePage },
            { path: "about", Component: About },
            {
                path: "iem",
                loader: async () => {
                    //fetch data about the filters etc from the backend
                    return { categoryName: "In-Ear Monitor" };
                },
                Component: CategoryListing,
            },
            {
                path: "headphones",
                loader: async () => {
                    //fetch data about the filters etc from the backend
                    return { categoryName: "Headphons" };
                },
                Component: CategoryListing,
            },
            {
                path: "dacs_amps",
                loader: async () => {
                    //fetch data about the filters etc from the backend
                    return { categoryName: "DACs and Amps" };
                },
                Component: CategoryListing,
            },
            {
                path: "accessories",
                loader: async () => {
                    //fetch data about the filters etc from the backend
                    return { categoryName: "Accessories" };
                },
                Component: CategoryListing,
            },
        ],
    },
]);

export default router;
