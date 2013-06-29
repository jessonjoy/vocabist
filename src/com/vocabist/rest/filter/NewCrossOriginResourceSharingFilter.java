package com.vocabist.rest.filter;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

/**
 * Created with IntelliJ IDEA.
 * User: jn
 * Date: 6/28/13
 * Time: 5:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class NewCrossOriginResourceSharingFilter implements ContainerResponseFilter{
    @Override
    public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {
        response.getHttpHeaders().putSingle("Access-Control-Allow-Origin", "*");
        response.getHttpHeaders().putSingle("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        response.getHttpHeaders().putSingle("Access-Control-Allow-Headers", "content-type, X-Requested-With");
        return response;
    }
}
