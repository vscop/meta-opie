DESCRIPTION = "Pipeman"
SECTION = "opie/games"
LICENSE = "GPLv2"
AUTHOR = "Rober Ernst"
HOMEPAGE = "http://www.linux-solutions.at/projects/zaurus/games-PDA-Pipeman.html"


SRC_URI = "http://sources.openembedded.org/pipeman_V1.0.0.tar.gz \
           file://pipe.patch"

S = "${WORKDIR}/pipeman_V${PV}"

LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f \
                    file://Pipeman.cpp;beginline=4;endline=12;md5=865e24c089f008b0e12624a42687cac4"

APPNAME = "pipeman"
APPTYPE = "binary"
APPDESKTOP = "${S}"


do_compile_prepend() {
	oe_runmake -C images
}

do_install () {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/*.png ${D}${palmtopdir}/pics/${APPNAME}/

}

inherit opie


SRC_URI[md5sum] = "8d8a69d0fea184dda5f4a15168039fbb"
SRC_URI[sha256sum] = "a2d8473577c2b3b51ebf29e2c6cb31463158676a5d5b44438ff0db18e8aab949"
