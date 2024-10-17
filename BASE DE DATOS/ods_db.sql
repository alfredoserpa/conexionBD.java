-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-10-2024 a las 16:24:53
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ods_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos_no_sostenibles`
--

CREATE TABLE `productos_no_sostenibles` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `stock` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos_no_sostenibles`
--

INSERT INTO `productos_no_sostenibles` (`id`, `nombre`, `precio`, `stock`) VALUES
(1, 'pera', 20, 3),
(2, 'pera', 12, 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos_sostenibles`
--

CREATE TABLE `productos_sostenibles` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `stock` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos_sostenibles`
--

INSERT INTO `productos_sostenibles` (`id`, `nombre`, `precio`, `stock`) VALUES
(1, 'pera', 12, 12),
(2, 'pera', 12, 12),
(3, 'pera', 12, 12),
(4, 'pera', 12, 2),
(5, 'pera', 12, 12);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `productos_no_sostenibles`
--
ALTER TABLE `productos_no_sostenibles`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `productos_sostenibles`
--
ALTER TABLE `productos_sostenibles`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `productos_no_sostenibles`
--
ALTER TABLE `productos_no_sostenibles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `productos_sostenibles`
--
ALTER TABLE `productos_sostenibles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
