cmake_minimum_required(VERSION 3.7)
set(CMAKE_MODULE_PATH ${CMAKE_MODULE_PATH} "${CMAKE_SOURCE_DIR}/cmake")
project(toolkit)

set(CMAKE_BUILD_TYPE Debug)
message("-- CMAKE_TOOLCHAIN_FILE: ${CMAKE_TOOLCHAIN_FILE}")
message("-- JAVA_HOME: ${JAVA_HOME}")

find_package(JNI REQUIRED)
include_directories(${JNI_INCLUDE_DIRS})

find_package(OpenGL REQUIRED)
include_directories(${OPENGL_INCLUDE_DIRS})

if (PLATFORM_NAME MATCHES "^linux")
    find_package(X11 REQUIRED)
    find_package(XCB REQUIRED COMPONENTS xcb-icccm xcb-keysyms)
    find_package(X11_XCB REQUIRED)
    include_directories(${X11_INCLUDE_DIRS} ${XCB_INCLUDE_DIRS} ${X11_XCB_INCLUDE_DIRS})
    set(CMAKE_C_FLAGS ${CMAKE_C_FLAGS} ${XCB_DEFINITIONS})
endif()

set(SRC src/main.c)

add_library(${PROJECT_NAME}-${PLATFORM_NAME} SHARED ${SRC})
target_link_libraries(${PROJECT_NAME}-${PLATFORM_NAME} ${JNI_LIBRARIES} ${X11_LIBRARIES} ${XCB_LIBRARIES}
        ${X11_XCB_LIBRARIES} ${OPENGL_LIBRARIES})
