# Use MySQL 8.0 as the base image
FROM mysql:8.0

# Set environment variables for MySQL configuration
# ROOT_PASSWORD, USER, and PASSWORD should be provided during container runtime
ENV MYSQL_ROOT_PASSWORD=password
ENV MYSQL_DATABASE=music_db
ENV MYSQL_USER=root
ENV MYSQL_PASSWORD=password

# Expose MySQL default port
EXPOSE 3306

# Add health check to verify MySQL is accepting connections
HEALTHCHECK --interval=30s --timeout=10s --start-period=5s --retries=3 \
CMD mysqladmin ping -h localhost -u ${MYSQL_USER} --password=${MYSQL_PASSWORD} || exit 1

