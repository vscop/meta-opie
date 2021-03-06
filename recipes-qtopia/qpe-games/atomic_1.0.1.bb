DESCRIPTION = "Atomic"
SECTION = "opie/games"

LICENSE = "GPL"
AUTHOR = "Andre Wuest"
HOMEPAGE = "http://www.linux-solutions.at/projects/zaurus/games-Atomic.html"


SRC_URI = "http://sources.openembedded.org/atomic_V1.0.1.tar.gz \
	   file://atomic.patch"

LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f \
                    file://Atomic.cpp;beginline=4;endline=12;md5=865e24c089f008b0e12624a42687cac4"

S = "${WORKDIR}/atomic_V${PV}"
APPNAME = "atomic"
APPTYPE = "binary"
APPDESKTOP = "${S}"




do_compile_prepend() {
	oe_runmake -C images
	oe_runmake -C tools
	oe_runmake -C levels
}

do_install () {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/*.png ${D}${palmtopdir}/pics/${APPNAME}/

}

inherit opie

SRC_URI[md5sum] = "537dc236f4654dd5760e0f39484222a1"
SRC_URI[sha256sum] = "818a18c1ace9bc3e5b92bc91db1d62c859023cd16444d41692ecb3606cc6868c"
