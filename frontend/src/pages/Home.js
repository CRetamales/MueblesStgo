// Pagina principal de la aplicacion
// Tiene un Carrousel con imagenes de la empresa

import React from 'react';
import { Carousel } from 'react-bootstrap';


const Home = () => {
    return (
        <div className="container-fluid width: 100%">
            <Carousel className="carousel slide" data-bs-ride="carousel" style={{marginTop: "3rem"}}>
                <Carousel.Item>
                

                    <img
                        class = "img-fluid max-width: 100% height: auto"
                        src="https://via.placeholder.com/2000x1000"
                        alt="First slide"/>
                    <Carousel.Caption>
                        <h3>First slide label</h3>
                        <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                    <img
                        className="img-fluid max-width: 100% height: auto"
                        src="https://via.placeholder.com/2000x1000"
                        alt="Second slide"
                    />
                    <Carousel.Caption>
                        <h3>Second slide label</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                    <img
                        className="img-fluid max-width: 100% height: auto"
                        src="https://via.placeholder.com/2000x1000"
                        alt="Third slide"
                    />
                    <Carousel.Caption>
                        <h3>Third slide label</h3>
                        <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
                    </Carousel.Caption>
                </Carousel.Item>
            </Carousel>
        </div>
    )
}

export default Home;


                    
