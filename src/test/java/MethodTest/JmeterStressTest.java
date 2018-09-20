package MethodTest;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import java.io.Serializable;

public class JmeterStressTest extends AbstractJavaSamplerClient implements Serializable, getDefaultParamters {

    @Override
    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        return null;
    }

    @Override
    public Arguments getDefaultParamters() {
      Arguments params = new Arguments();
      return params;
      //params.addArgument("");
    }
}
