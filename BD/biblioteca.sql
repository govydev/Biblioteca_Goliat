-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 03-07-2019 a las 02:37:28
-- Versión del servidor: 5.5.21
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `biblioteca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autor`
--

CREATE TABLE `autor` (
  `idautor` int(11) NOT NULL,
  `nombres` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(30) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `autor`
--

INSERT INTO `autor` (`idautor`, `nombres`, `apellidos`) VALUES
(1, 'Antoine', 'Saint-Exupery'),
(2, 'Bill', 'Finger'),
(3, 'Greg', 'Pak'),
(4, 'Ernesto ', 'Sabato'),
(5, 'J.M.', 'DeMatteis'),
(6, 'Jorge', 'Jimene'),
(7, 'Kitty', 'Kelley'),
(8, 'Maquiavelo', ''),
(9, 'Mark ', 'Millar'),
(10, 'Miguel ', 'Cervantes'),
(11, 'Benito', 'Perez Galdos'),
(12, 'Pu-Yi', ''),
(13, 'Stan', 'Lee'),
(14, 'Ellis', 'Warren'),
(15, 'William', 'Faulkner'),
(16, 'Kentaro', 'Miura'),
(17, 'Hideaki', 'Anno'),
(18, 'Junji', 'Ito'),
(19, 'Youchi', 'Takahashi'),
(20, 'Shuzou', 'Oshimi'),
(21, 'Alan', 'Poe');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `idcategoria` int(11) NOT NULL,
  `categoria` varchar(30) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`idcategoria`, `categoria`) VALUES
(1, 'Libro'),
(2, 'Comic'),
(3, 'Manga');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL,
  `nombres` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `correo` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `idpais` int(11) NOT NULL,
  `usuario` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `contraseña` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idcliente`, `nombres`, `apellidos`, `telefono`, `correo`, `idpais`, `usuario`, `contraseña`, `estado`) VALUES
(1, 'Flynn', 'Mcdonald', '(676) 251', 'risus@Praesentluctus.com', 1, 'Flynn', '123', 1),
(2, 'Breanna', 'Rush', '(365) 303', 'auctor.vitae@nullaante.net', 1, 'Breanna', '123', 1),
(3, 'Daria', 'Trevino', '(868) 570', 'Sed.nulla.ante@diamluctuslobor', 1, 'Daria', '123', 1),
(4, 'Lesley', 'Alvarado', '(851) 229', 'lacus.pede.sagittis@purusgravi', 2, 'Lesley', '456', 1),
(5, 'Merritt', 'Kirkland', '(611) 250', 'rhoncus@Phasellus.org', 2, 'Merritt', '456', 1),
(6, 'Jaquelyn', 'Mooney', '(224) 324', 'pellentesque@estvitae.com', 2, 'Jaquelyn', '456', 1),
(7, 'Abel', 'Fulton', '(436) 591', 'Nunc.mauris.elit@sedconsequata', 3, 'Abel', '789', 1),
(8, 'Cheryl', 'Strickland', '(610) 238', 'molestie.tortor@metus.edu', 3, 'Cheryl', '789', 1),
(9, 'Eugenia', 'Morales', '(356) 302', 'nunc.sed.libero@Proin.net', 3, 'Eugenia', '789', 1),
(10, 'Francis', 'Rich', '(274) 371', 'dolor.elit.pellentesque@cursus', 4, 'Francis', '147', 1),
(11, 'Benedict', 'Warren', '(997) 797', 'ut.ipsum@odiovel.edu', 4, 'Benedict', '147', 1),
(12, 'Alexis', 'Curry', '(896) 304', 'Fusce@Sedet.net', 4, 'Alexis', '147', 1),
(13, 'Jasper', 'Carpenter', '(390) 703', 'cubilia.Curae@aliquet.com', 5, 'Jasper', '258', 1),
(14, 'Piper', 'Guy', '(102) 127', 'senectus@eratSednunc.ca', 5, 'Piper', '258', 1),
(15, 'Xanthus', 'Weber', '(578) 849', 'vulputate.nisi.sem@ante.org', 5, 'Xanthus', '258', 1),
(16, 'Marny', 'Emerson', '(701) 768', 'vel.lectus@risusodio.ca', 5, 'Marny', '369', 1),
(17, 'Edward', 'Anderson', '(134) 553', 'Nunc.pulvinar@semeget.edu', 6, 'Edward', '369', 1),
(18, 'Hedley', 'Davenport', '(413) 849', 'blandit@Praesenteu.net', 6, 'Hedley', '369', 1),
(19, 'Antonio', 'Gutierz', '910232', 'ghma28', 6, 'GA#28', '123', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `editorial`
--

CREATE TABLE `editorial` (
  `ideditorial` int(11) NOT NULL,
  `editorial` varchar(30) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `editorial`
--

INSERT INTO `editorial` (`ideditorial`, `editorial`) VALUES
(1, 'Alfaguara'),
(2, 'Anaya'),
(3, 'Andina'),
(4, 'Caralt'),
(5, 'Panini'),
(6, 'Plaza & Jane'),
(7, 'S.M.'),
(8, 'Viz media');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `idempleado` int(11) NOT NULL,
  `nombres` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `correo` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `idpais` int(11) NOT NULL,
  `usuario` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `contraseña` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`idempleado`, `nombres`, `apellidos`, `telefono`, `correo`, `idpais`, `usuario`, `contraseña`, `estado`) VALUES
(1, 'Uta', 'Chan', '(276) 332', 'pellentesque.massa@Nuncmauris.', 1, 'Uta', '987', 1),
(2, 'Oleg', 'Stout', '(907) 630', 'amet@Donec.edu', 1, 'Oleg', '987', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero`
--

CREATE TABLE `genero` (
  `idgenero` int(11) NOT NULL,
  `genero` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `idcategoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `genero`
--

INSERT INTO `genero` (`idgenero`, `genero`, `idcategoria`) VALUES
(1, 'Autobiograficas', 1),
(2, 'Aventura', 1),
(3, 'Biograficas', 1),
(4, 'Caballeresco', 1),
(5, 'Novela', 1),
(6, 'Político', 1),
(7, 'Ciencia Ficción', 2),
(10, 'Seinen', 3),
(11, 'Shounen', 3),
(12, 'Hechi', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pais`
--

CREATE TABLE `pais` (
  `idpais` int(11) NOT NULL,
  `pais` varchar(20) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pais`
--

INSERT INTO `pais` (`idpais`, `pais`) VALUES
(1, 'Brasil'),
(2, 'Canada'),
(3, 'Costa Rica'),
(4, 'España'),
(5, 'Estados Unidos'),
(6, 'Perú'),
(7, 'Chile');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idproducto` int(11) NOT NULL,
  `titulo` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `idautor` int(11) NOT NULL,
  `idgenero` int(11) NOT NULL,
  `ideditorial` int(11) NOT NULL,
  `fechaPublicacion` date NOT NULL,
  `sinopsis` text COLLATE utf8_spanish_ci NOT NULL,
  `direccion` text COLLATE utf8_spanish_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idproducto`, `titulo`, `idautor`, `idgenero`, `ideditorial`, `fechaPublicacion`, `sinopsis`, `direccion`) VALUES
(10, 'El tunel', 4, 5, 2, '1948-02-16', 'Juan Pablo Castel es un pintor recluido en prisión por el asesinato de María Iribarne. Durante su encierro rememora la cadena de acontecimientos que le llevaron a perder el control, a convertirse en un hombre con el interior oscuro, un hombre \r\nposeído por una insalvable soledad, la de la ausencia de la mujer amada hasta el límite, la del engaño que ha convertido \r\nsu corazón en un pedazo duro y frío de hielo y ha colocado entre sus manos el cuchillo que pone fin al sufrimiento.', 'http://biblio3.url.edu.gt/Libros/sabato/tunel.pdf'),
(11, 'Don Quijote de La Mancha I', 10, 4, 2, '1991-04-23', 'Alonso Quijano es un hidalgo pobre de la Mancha, que de tanto leer novelas de caballería acaba enloqueciendo y creyendo ser un caballero andante, nombrándose a sí mismo como Don Quijote de la Mancha. Sus intenciones son ayudar a los pobres y desfavorecidos, y lograr el amor de la supuesta Dulcinea del Toboso, que es en realidad es una campesina llamada Aldonza Lorenzo. La primera salida la hace solo, pero regresa en poco tiempo a casa y decide nombrar a Sancho Panza, un empleado suyo, escudero. Juntos realizan la segunda salida, en la que viven más de una aventura: Don Quijote ve y ataca a unos gigantes que en realidad resultan ser molinos de viento, confunde un rebaño con un ejército, tiene más de una disputa, una de ellas con un vizcaíno, y llega a enfrentarse a unos leones. Finalmente, y tras hacer penitencia en un bosque, es capturado por el cura y el barbero de su pueblo y llevado a casa en una jaula tras ser engañado para ayudar a la supuesta princesa Micomicona.', 'http://www.daemcopiapo.cl/Biblioteca/Archivos/7_6253.pdf '),
(12, 'Don Quijote de La Mancha II', 10, 4, 2, '1991-04-23', 'En la tercera y última salida, las aventuras más destacadas son las de La cueva de Montesinos, donde Don Quijote sueña mil maravillas, el rebuzno de Sancho Panza, y para finalizar, la derrota de Don Quijote ante el Caballero de la Blanca Luna, razón por la que se retira su hogar, donde, tras adquirir de nuevo la cordura, fallece.', 'http://www.biblioteca.org.ar/libros/89969.pdf'),
(13, 'El príncipe', 8, 6, 7, '1995-08-27', 'El Príncipe de Nicolás de Maquiavelo (Florencia, 1469-1527) es, sin duda, un clásico en el sentido más literal del término, pero también uno de los libros peor entendidos de la historia de la literatura mundial. Baste pensar en el sentido negativo que en todas las lenguas se da a los términos maquiavelismo y maquiavélico. Con ellos usualmente se designa un uso del poder político carente de prejuicios, en el que el fin justifica cualquier medio. No ha existido hombre poderoso en la tierra, desde Carlos V a Catalina de Médicis, de Luis XIV a Napoleón, hasta los dictadores de la época contemporánea, que no hayan sido acusados de leer secretamente El Príncipe para obtener consejo e inspiración.', 'https://ocw.uca.es/pluginfile.php/1491/mod_resource/content/1/El_principe_Maquiavelo.pdf'),
(14, 'El principito', 1, 2, 3, '1996-01-15', 'El principito vive en un pequeño planeta, el asteroide B 612, en el que hay tres volcanes (dos de ellos activos y uno no) y una rosa. Pasa sus días cuidando de su planeta, y quitando los árboles baobab que constantemente intentan echar raíces allí. De permitirles crecer, los árboles partirían su planeta en pedazos.\r\n\r\nUn día decide abandonar su planeta, quizás cansado de los reproches y reclamos de la rosa, para explorar otros mundos. Aprovecha una migración de pájaros para emprender su viaje y recorrer el universo; es así como visita seis planetas, cada uno de ellos habitado por un personaje: un rey, un vanidoso, un borracho, un hombre de negocios, un farolero y un geógrafo, los cuales, a su manera, demuestran lo vacías que se vuelven las personas cuando se transforman en adultas.\r\n\r\nEl último personaje que conoce, el geógrafo, le recomienda viajar a un planeta específico, la Tierra, donde entre otras experiencias acaba conociendo al aviador que, ya habíamos comentado, estaba perdido en el desierto.', 'http://www.agirregabiria.net/g/sylvainaitor/principito.pdf'),
(15, 'El Último Emperador', 12, 1, 4, '1989-09-19', 'La figura de Pu yi, último emperador de China, es una de las más contradictorias de la historia contemporánea. Nacido en la corte de Pekín, educado en el ritual minucioso de la Casa Imperial China, emperador a la edad de dos años, fue luego depuesto y tuvo que huir a Tientsin, donde vivió la amargura del exilio hasta que la fuerza de invasión japonesa le colocó durante años como emperador de Manchukúo. Tras la paz de 1945, Pu Yi vivió prisionero de los rusos, luego de los chinos. Reeducado psicológicamente, el antiguo soberano de centenares de millones de hombres se convirtió en un súbdito fervoroso y disciplinado de Mao.', 'http://www.mcnbiografias.com/app-bio/do/show?key=puyi'),
(16, 'Fortunata y Jacinta', 11, 5, 6, '1984-02-16', 'El papel de la mujer en la sociedad, con Fortunata y Jacinta como máximas exponentes, la hipocresía dominante en una burguesía que intenta superar su anquilosamiento, la religiosidad asfixiante y dominante, los hábitos más generalizados, las costumbres más arraigadas..., todo ello se da cita en esta grandísima novela, que es el mayor exponente del realismo literario', 'http://www.biblioteca.org.ar/libros/92692.pdf'),
(19, 'Batman of Arkham', 2, 7, 5, '2015-03-14', 'En este cuento de Elseworlds, alrededor de 1900, Bruce Wayne dirige el lugar: un psiquiatra respetado durante el día y un vigilante que ayuda a llenar las celdas del asilo durante la noche. Sus tratamientos son exhaustivos y compasivos, un cambio significativo en comparación con las representaciones habituales del asilo, y mide una tasa de éxito justa con sus pacientes.\r\n\r\nMientras tanto, el Joker está extendiendo su maníaca locura por la ciudad, y Jonathan Crane es un miembro subordinado del personal de asilo con sus propios puntos de vista sobre la atención al paciente. Cuando Wayne cae víctima del Joker y queda en un estado maníaco, Crane tiene la oportunidad de hacer su voluntad más dura en los pacientes. Sin embargo, Bruce se recuperó del gas y capturó al Joker. Bruce luego dedicó su vida a curar el Joker.', 'https://vercomics.com/batman-arkham-knight-1/'),
(20, 'Civil War I', 9, 7, 5, '2016-08-03', 'Civil War cuenta la implementación y las consecuencias del Acta de Registro Sobrehumano, un proyecto de ley que requiere el registro obligatorio de cualquier persona ubicada en Estados Unidos con súper poderes. El Acta surgió debido a la presión pública para rendir cuentas a raíz de una serie de eventos relacionados con sobrehumanos causando daño y muertes significativas dentro del Universo Marvel, como un ataque en Manhattan en represalia por la Guerra Secreta de Nick Fury, y la furia de Hulk en Las Vegas que resultó en la muerte de 26 personas. Cuando la población mutante fue reducida drásticamente como consecuencia del Día-M, causado en sí por una mutante, la histeria anti-mutante causó que grupos extremistas hicieran que la mayoría de los mutantes restantes, conocidos como los 198, fueran trasladados al Instituto Xavier, y recaudaron apoyo público para el propuesto Acta.\r\n\r\nEl sentimiento público hacia los superhéroes se desplomó después de un incidente en Stamford, Connecticut, en el cual los Nuevos Guerreros, un grupo de jóvenes superhéroes y el centro de un reality show televisivo, cometieron un error intentando capturar a un grupo de supervillanos en su búsqueda de popularidad. En la lucha resultante, el villano Nitro usó sus poderes explosivos para destruir varias zonas de la ciudad, incluyendo una escuela primaria en el centro, con la consecuencia de más de 600 civiles muertos, 60 de los cuales eran niños, con solo Speedball de los Guerreros y el propio Nitro sobreviviendo. A pesar de que muchos superhéroes de alto perfil ayudaron en las labores de ayuda y rescate, hubo una serie de ataques de venganza aislados, y el apoyo para el Acta se elevó.\r\n\r\nLa perspectiva del registro dividió a la comunidad sobrehumana a la mitad, con Tony Stark, el superhéroe Iron Man quien había intentado previamente detener el Acta, convirtiéndose en el líder pro-registro, y el Capitán América liderando el grupo anti-registro. Iron Man, con el Sr. Fantástico y Henry Pym, argumenta que el cambiante panorama político significa que resistirse a la ley es inútil, y que es razonable para los héroes tener la capacitación y la supervisión adecuadas, mientras que el Capitán América, con Luke Cage y Falcon, argumenta que los héroes requieren secretismo con el fin de proteger aspectos de sus vidas \'normales\', como cónyuges e hijos, y permitirles actuar en todos los medios necesarios contra amenazas que los servicios de emergencia ordinarios no puedan hacerles frente. Aunque nominalmente es una agencia de las Naciones Unidas, S.H.I.E.L.D. asume el peso de hacer cumplir el Acta bajo la directora interina Maria Hill.', 'https://vercomics.com/civil-war-1/'),
(21, 'Fantasy 15 amazing', 13, 7, 5, '1962-05-26', 'El tímido estudiante de secundaria sin muchas pretensiones Peter Parker prefiere la compañía de sus maestros a la de sus compañeros de clase, quienes lo apodan como el \'único cero a la izquierda profesional de la Secundaria Midtown\'. Sus únicos parientes vivos, su tía May y tío Ben, lo adoran y lo tienen en una alta estima.\r\nUna noche, mientras asistía a una demostración sobre la radiactividad en un salón de ciencias, Peter no se da cuenta que una araña cae a través de un \'rayo radiactivo\' y recibe una dosis masiva de radiación. Ésta lo muerde y después se muere. Mareado, Peter se retira de la exposición, sólo para que en la calle casi lo atropelle un coche que pasaba. Salta rápidamente a un lugar seguro para evitarlo, pero se sorprende al ver que había saltado una distancia mucho mayor de lo que había intentado. Se percata de que había aterrizado en el costado de un edificio y que se aferra a los ladrillos con la punta de sus dedos. Rápidamente sube trepando hasta la azotea y una vez allí, arruga accidentalmente una tubería de acero con una sola mano. Cree que podría haber heredado de la araña su velocidad y fuerza proporcionales en comparación a escala humana y además su habilidad para trepar por las superficies. Entonces es cuando comienza a reflexionar sobre las posibilidades.\r\nPoco después, Peter ve a un cuadrilátero de lucha libre junto a un anuncio: \"$100 para el hombre que puede permanecer en el cuadrilátero tres minutos contra \'Crusher Hogan\". Regresa a su casa, se cambia sus ropas, se pone una capucha, y regresa al cuadrilátero. Hogan riendo se burla de Peter llamándolo como \'Masked Marvel\' (Maravilla Enmascarada), pero entonces Peter levanta a Hogan sobre su cabeza y lo carga hasta una esquina. Después, un hombre entre la multitud se presenta a si mismo ante Peter como un productor de televisión, lo anima a entrar en el mundo del espectáculo, y le entrega su tarjeta.\r\n\r\nen:\r\nStan Lee/Editor-en-Jefe, Jack Kirby/Artista de Portada, Steve Ditko/Artista de Portada 	y 20 más\r\nAmazing Fantasy Vol 1 15\r\nEspañol\r\nEDITAR\r\n \r\nCOMPARTIR\r\n Information-silk Amazing Fantasy #15\r\nPortada\r\nPortada variante\r\n Portada\r\nPublicado\r\nAgosto, 1962\r\nInformation-silk\r\nEditor en jefe\r\nStan Lee\r\nInformation-silk\r\nArtista de portada\r\nJack Kirby, Steve Ditko\r\n\"Spider-Man!\"\r\nInformation-silk\r\nEscritores\r\nStan Lee\r\nInformation-silk\r\nDibujantes\r\nSteve Dikto\r\nInformation-silk\r\nEntintadores\r\nSteve Dikto\r\nInformation-silk\r\nRotuladores\r\nArtie Simek\r\nInformation-silk\r\nEditores\r\nStan Lee\r\n\"The Bell-Ringer!\"\r\n\"Man in the Mummy Case!\"\r\n\"There Are Martians among Us!\"\r\nInformation-silk\r\nCómic anterior\r\nInformation-silk\r\nCómic siguiente\r\nAmazing Adult Fantasy #14\r\n(julio, 1962)\r\nAmazing Fantasy #16\r\n(diciembre, 1995)\r\nContenido[mostrar]\r\nHistoria #1\r\nProtagonistas:\r\n\r\nPersonaje principal\r\n\r\nSpider-Man (Peter Parker)\r\nPersonajes secundarios\r\n\r\nTía May (primera aparición)\r\nTío Ben (primera aparición) (muerte)\r\nFlash Thompson (primera aparición)\r\nLiz Allan (primera aparición)\r\nNew York Police Department\r\nBernard O\'Brien (única aparición)[1] (no aparece nombrado)\r\nAntagonistas\r\n\r\nAsaltante (primera aparición)\r\nOtros personajes\r\n\r\nRaymond Warren, uno de los profesores de Peter (primera aparición)\r\nAraña radioctiva (primera aparición) (muerte)\r\nEstudiante de la Secundaria Midtown\r\nCientíficos\r\nDr. Eric Schwinner (primera aparición)\r\nMax Shiffman, productor de televisión (primera aparición)\r\nCrusher Hogan (primera aparición)\r\nSeymour O\'Reilly (primera aparición) (no aparece nombrado)\r\nSally Avril (primera aparición)\r\nBaxter Bigelow (única aparición) (no aparece nombrado)\r\nChet Huntley (no aparece nombrado)\r\nSinopsis: Spider-Man!\r\n\r\nParte 1\r\n\r\nEl tímido estudiante de secundaria sin muchas pretensiones Peter Parker prefiere la compañía de sus maestros a la de sus compañeros de clase, quienes lo apodan como el \'único cero a la izquierda profesional de la Secundaria Midtown\'. Sus únicos parientes vivos, su tía May y tío Ben, lo adoran y lo tienen en una alta estima.\r\n\r\nPagina spider\r\nUna noche, mientras asistía a una demostración sobre la radiactividad en un salón de ciencias, Peter no se da cuenta que una araña cae a través de un \'rayo radiactivo\' y recibe una dosis masiva de radiación. Ésta lo muerde y después se muere. Mareado, Peter se retira de la exposición, sólo para que en la calle casi lo atropelle un coche que pasaba. Salta rápidamente a un lugar seguro para evitarlo, pero se sorprende al ver que había saltado una distancia mucho mayor de lo que había intentado. Se percata de que había aterrizado en el costado de un edificio y que se aferra a los ladrillos con la punta de sus dedos. Rápidamente sube trepando hasta la azotea y una vez allí, arruga accidentalmente una tubería de acero con una sola mano. Cree que podría haber heredado de la araña su velocidad y fuerza proporcionales en comparación a escala humana y además su habilidad para trepar por las superficies. Entonces es cuando comienza a reflexionar sobre las posibilidades.\r\n\r\nPoco después, Peter ve a un cuadrilátero de lucha libre junto a un anuncio: \"$100 para el hombre que puede permanecer en el cuadrilátero tres minutos contra \'Crusher Hogan\". Regresa a su casa, se cambia sus ropas, se pone una capucha, y regresa al cuadrilátero. Hogan riendo se burla de Peter llamándolo como \'Masked Marvel\' (Maravilla Enmascarada), pero entonces Peter levanta a Hogan sobre su cabeza y lo carga hasta una esquina. Después, un hombre entre la multitud se presenta a si mismo ante Peter como un productor de televisión, lo anima a entrar en el mundo del espectáculo, y le entrega su tarjeta.\r\n\r\nEn casa, Parker se hace un disfraz con temática de araña, una provisión de líquido pegajoso como una telaraña, y dos surtidores para sus muñecas con los que puede disparar el líquido. Después pronuncia en voz alta: \'¡Aquí viene Spider-Man!\'', 'https://vercomics.com/amazing-fantasy-15/'),
(22, 'Justice League', 14, 7, 5, '1965-11-04', 'La Justice League, llamada en español La liga de la justicia, es el equipo de superhéroes más poderoso de la Tierra. A medida que ha pasado el tiempo sus miembros han ido variando, pero usualmente el equipo original está conformado por Batman, Superman, Wonder Woman, Flash, Green Lantern, Aquaman y Martian Manhunter.', 'https://vercomics.com/justice-league-01/'),
(23, 'La ultima caceria de Kraven', 5, 7, 5, '1998-06-30', 'Kraven El Cazador ha acechado y acabado con la vida de todos los animales conocidos por el hombre. Pero hay una bestia que se le resiste: una que se burló de él en cada encuentro: el superhéroe conocido como Spiderman. Ahora el tiempo de jugar ha terminado. Acabará con la araña, la enterrará y se convertirá en ella. Empieza la Última Cacería de Kraven.', 'https://vercomics.com/the-amazing-spiderman-vol1-293/'),
(24, 'One More Day', 6, 7, 5, '2006-12-12', 'One More Day es la consecuencia de los actos que Peter realizó durante la Civil War al revelar su identidad, manipulado por Tony Stark y de alguna forma por su Tía May\r\n\r\nEn dicha historia veremos a Peter luchar contra las adversidades a fin de salvar la vida de su Tía May a quien le ha disparado un francotirador contratado por Kingpin desde la Cárcel.\r\n\r\nEs acå donde Peter debe decidir si sacrifica lo que mas ama por salvar a su Tía o dejarla ir al mas allá', 'https://comicoon.blogspot.com/2013/02/spiderman-un-dia-mas.html'),
(25, 'weapon x', 3, 7, 5, '1968-07-24', 'Arma X es un proyecto de instalación de investigación genética del gobierno clandestino ficticio que aparece en los cómics estadounidenses publicados por Marvel Comics. Se llevan a cabo por el Departamento K del Gobierno de Canadá, lo que convierte a los seres dispuestos y no están dispuestos en armas vivientes. El proyecto a menudo captura mutantes y realiza experimentos en ellos para mejorar sus habilidades o superpoderes, convirtiéndolos en armas. También mutan a los humanos de línea de base. El proyecto Arma X produjo a Wolverine, Leech, Deadpool y Sabretooth.', 'https://tiocammoi.com/marvel/weapon-x-volumen-3-25-de-espanol/'),
(26, 'Berserk', 16, 10, 5, '1989-05-13', 'Gatsu, un hombre al que le falta un ojo y un brazo y va en busca de venganza. Mediante un flashback de varios tomos se cuenta la historia desde niño hasta formar parte de la banda de mercenarios más famosa de la época. Finalmente se llega al motivo por el cual desea venganza.<br>Historia  situada en la edad medieval.        ', 'https://drive.google.com/drive/mobile/folders/1Dzf_N5nSPyVx1IbVDEdla8_0eZD3h_HU'),
(27, 'Neon Genesis Evangelion', 17, 10, 5, '1994-12-26', 'La serie se inicia en el año 2015 de la era cristiana, quince años después del primer y desastroso contacto con unos misteriosos seres conocidos como ángeles, que resultó en un cataclismo a escala mundial llamado Segundo Impacto, que redujo a la mitad la población humana en la Tierra.\r\n\r\nEl Impacto provocó tsunamis devastadores y un cambio en la inclinación del eje de la Tierra (que conducen al cambio climático global), así como una posterior agitación geopolítica, provocando guerras nucleares (como el ataque con armas nucleares a Tokio), y una crisis económica general.\r\n\r\nPara prevenir futuros ataques de ángeles, la ONU estableció en Tokio-3 la organización NERV, la cual desarrolló una serie de gigantes biomecánicos llamados Evangelion —abreviado EVA— para combatirlos. Debido a que los Evangelion solo pueden ser pilotados por adolescentes, el dirigente de NERV, Gendo Ikari, se comunica con su distanciado hijo, Shinji, para que pilote la Unidad-01 de los Evangelion, y acabe con el tercer ángel, que se halla atacando la ciudad.\r\nAunque al principio Shinji se niega a cooperar, acaba accediendo al ver el acto aparentemente cruel de su padre de obligar a la malherida Rei Ayanami a pilotar el EVA.\r\n\r\nA bordo del Evangelion, Shinji es dejado inconsciente al poco tiempo de comenzar la batalla, pero súbitamente el EVA entra en modo berserk, actúa por sí mismo y destruye al ángel.', 'https://mega.nz/#F!MyAz0BqA!e8yfTRfic5E5X7X9ZqcE-w'),
(28, 'Gyo Ugomeku Bukimi', 18, 10, 8, '2001-03-26', 'Tadashi y su novia Kaori siguen lo que se supone que son las vacaciones perfectas en Okinawa. Pero durante una inmersión en el mar, Tadashi descubre una extraña criatura que se mueve rápido disparada por él como una bala. Además de eso, la sensible nariz de Kaori hace que se queje del olor del mar y del pescado. \r\n\r\nDespués de una discusión, Kaori sale de la casa, y los dos descubren que un olor aún más horrible está impregnando el aire: ¡un pez muerto con patas grotescas! Al día siguiente, la ciudad está invadida por los peces muertos que caminan, y se están extendiendo por Japón', 'https://drive.google.com/drive/mobile/folders/1W4P-pXKozn7t0pNmlPT_6CnSX4iGYglJ'),
(29, 'Captain Tsubasa', 19, 11, 5, '1981-06-16', 'Para el torneo de la Secundaria, Oliver y sus compañeros ya no cuentan ni con Benji Price (quien se ha ido a Alemania), ni con Tom Misaki, compañero de ataque de Oliver (quien se ha ido a Francia con su padre pintor); pero sigue con su fiel amigo Bruce Harper en la defensa acompañado del fornido Víctor Takasugi para guardar la portería defendida por Al Crocket y el apoyo en labores ofensivas de Johnny Mason, Paul Diamond y Eddie Carter. Arthur pasó a formar parte de la barra del Newpy y Patty Haydee, quien de más niña era quien llevaba las porras y ahora es asistente del Entrenador Conrad (junto con otras dos muchachas llamadas Eva y Anabel) y apoya a Oliver (de quien siempre ha estado enamorada).\r\n\r\nEl rival principal no cambia, pero Steve Hyuga se ha ido becado al Colegio Superior (Toho) junto con Richard Tex Tex y Ralph Mellow; Oliver debe de enfrentar en la clasificatoria a sus ex-compañeros Jack Morris, Raúl y Jorge más el goleador David Everett, todos del Colegio Otomo. Superado ese bache, ya no se encuentra en el Torneo Nacional con Borgini y Andy Johnson (eliminados en fases previas), pero tiene nuevos y duros adversarios en Guillermo Peterson (Colegio Asturiano) y Víctor Clifford (Halcones), además de volver a medirse con los Hermanos Koriotto y enfrentarse al fin con su amigo Armand Callahan (Colegio Furano).\r\n\r\nEl enfrentamiento en la final contra el Colegio Superior tiene a un Oliver diezmado por una lesión en el hombro izquierdo y otra en el tobillo derecho… pero por compensación, él ha logrado desarrollar su “tiro de remate“, un remate de gran potencia y efecto (aunque Steve Hyuga ha desarrollado el “tiro del tigre”, de una energía impresionante). La final termina 4-4 y ambos equipos son proclamados campeones y se nomina a una Selección que jugará un torneo en Europa.', 'https://www.taringa.net/+imagenes/super-campeones-manga-comic-capitulo-1_gdn5j'),
(30, 'Aku no Hana', 20, 11, 5, '2009-09-09', 'La historia tiene lugar en la ciudad de Kiryū, prefectura de Gunma.4 Takao Kasuga es un joven al que le encanta leer, especialmente el libro Les fleurs du mal (Las flores del mal), una antología de poemas de Charles Baudelaire. Está enamorado de Nanako Saeki, una compañera de clase particularmente popular y a la cual idealiza. Un día, de camino a casa, Kasuga se percata de haber olvidado su libro en el instituto, por lo que decide volver para recogerlo. Al llegar, encuentra, además de su libro, que Saeki ha olvidado su uniforme de gimnasia, y por pánico, creyendo que alguien lo descubriría; se lo lleva consigo. El rumor de que un pervertido le ha robado el uniforme de gimnasia a Saeki se extiende como la pólvora, y Kasuga se siente culpable y avergonzado por ello. Esto no pasará desapercibido para Sawa Nakamura, la chica más asocial de la clase, quien le vio llevarse el uniforme. Algo que ella aprovechará para extorsionar a Kasuga, y controlarlo a placer.\r\nMientras Kasuga pasa más tiempo con las dos chicas, se encuentra cada vez más culpable de sus acciones, como cuando intenta confesarse vandalizando junto a Nakamura. Su familia se entera del incidente del aula, Kasuga escapa con Nakamura hacia las montañas, lidiando con sus remordimientos. La relación de Kasuga y Saeki va peor, pero mantiene una buena relación con Nakamura, quienes se ven a menudo fuera de clases en las tardes, en un improvisado refugio cerca de las montañas, el cual es incendiado durante las vacaciones de verano.\r\n\r\nSaeki se involucra de nuevo con ambos chicos y causa más problemas a la escuela y a la policía. Durante un evento en un festival, Nakamura y Kasuga aparecen juntos con intenciones mortales. Años después del evento del festival, Kasuga atiende una escuela en Ōmiya-ku, Saitama, donde aún lucha con su poca confianza al hablar con el resto de la clase y no ha podido olvidar su a Nakamura. Ahí conoce a una chica entusiasta de la lectura, se enamora y juntos intentan visitar el lugar donde el pasado de Kasuga le atormenta, visitando a Nakamura para arreglar sus asuntos.\r\n', 'https://drive.google.com/drive/mobile/folders/1eKBLdE4AUHOjsCsOuuPmJ2Rr7pJF-3XJ?usp=sharing');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sugerencia`
--

CREATE TABLE `sugerencia` (
  `idsugerencia` int(11) NOT NULL,
  `sugerencia` text COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `sugerencia`
--

INSERT INTO `sugerencia` (`idsugerencia`, `sugerencia`) VALUES
(1, 'Suban los libros de terror de Stephen King como IT');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `autor`
--
ALTER TABLE `autor`
  ADD PRIMARY KEY (`idautor`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`idcategoria`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idcliente`),
  ADD KEY `idpais` (`idpais`);

--
-- Indices de la tabla `editorial`
--
ALTER TABLE `editorial`
  ADD PRIMARY KEY (`ideditorial`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`idempleado`),
  ADD KEY `idpais` (`idpais`);

--
-- Indices de la tabla `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`idgenero`),
  ADD KEY `idcategoria` (`idcategoria`);

--
-- Indices de la tabla `pais`
--
ALTER TABLE `pais`
  ADD PRIMARY KEY (`idpais`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idproducto`),
  ADD KEY `idautor` (`idautor`),
  ADD KEY `idgenero` (`idgenero`),
  ADD KEY `ideditorial` (`ideditorial`);

--
-- Indices de la tabla `sugerencia`
--
ALTER TABLE `sugerencia`
  ADD PRIMARY KEY (`idsugerencia`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `autor`
--
ALTER TABLE `autor`
  MODIFY `idautor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `idcategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idcliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT de la tabla `editorial`
--
ALTER TABLE `editorial`
  MODIFY `ideditorial` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `idempleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `genero`
--
ALTER TABLE `genero`
  MODIFY `idgenero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT de la tabla `pais`
--
ALTER TABLE `pais`
  MODIFY `idpais` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idproducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT de la tabla `sugerencia`
--
ALTER TABLE `sugerencia`
  MODIFY `idsugerencia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`idpais`) REFERENCES `pais` (`idpais`);

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`idpais`) REFERENCES `pais` (`idpais`);

--
-- Filtros para la tabla `genero`
--
ALTER TABLE `genero`
  ADD CONSTRAINT `genero_ibfk_1` FOREIGN KEY (`idcategoria`) REFERENCES `categoria` (`idcategoria`);

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`idautor`) REFERENCES `autor` (`idautor`),
  ADD CONSTRAINT `producto_ibfk_3` FOREIGN KEY (`idgenero`) REFERENCES `genero` (`idgenero`),
  ADD CONSTRAINT `producto_ibfk_4` FOREIGN KEY (`ideditorial`) REFERENCES `editorial` (`ideditorial`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
