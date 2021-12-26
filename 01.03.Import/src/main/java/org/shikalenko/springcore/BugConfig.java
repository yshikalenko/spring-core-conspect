package org.shikalenko.springcore;

import org.springframework.context.annotation.Configuration;

@Configuration
class BugConfig {
	Bug bug() {
		return new Bug();
	}
}